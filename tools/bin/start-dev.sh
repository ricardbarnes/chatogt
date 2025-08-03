#!/usr/bin/env bash
set -euo pipefail

PROJECT_NAME="chatogt-dev-infra"

# Navigate to the monorepo root
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/../../" && pwd)"

COMPOSE_FILE="$REPO_ROOT/tools/docker/compose/docker-compose.yml"

# --- Functions ---

function check_command() {
  if ! command -v "$1" >/dev/null 2>&1; then
    echo "❌  Missing required command: $1"
    exit 1
  fi
}

function check_docker_running() {
  if ! docker info >/dev/null 2>&1; then
    echo "❌  Docker is not running or you don't have permission."
    exit 1
  fi
}

function check_docker_compose_v2() {
  if ! docker compose version >/dev/null 2>&1; then
    echo "❌  'docker compose' (v2) is not available. Please install Docker CLI v2+."
    exit 1
  fi
}

# --- Check if infra is already running ---

running_containers=$(docker ps --filter "label=com.docker.compose.project=$PROJECT_NAME" -q)

if [[ -n "$running_containers" ]]; then
  echo "ℹ️  Development infrastructure is already running. No action taken."
  exit 0
fi

# --- Checks ---

echo "🔍 Checking development prerequisites..."

check_command docker
check_docker_running
check_docker_compose_v2

echo "✅  All required tools are available."

# --- Infra start ---

echo "🟡  Starting development infrastructure using docker-compose..."
docker compose -p "$PROJECT_NAME" \
  -f "$COMPOSE_FILE" \
  up -d

echo "✅  Services are starting in the background."

# Wait for all services with health checks to be healthy
echo "⏳  Waiting for containers with health checks to be healthy..."
for service in $(docker compose -f "$COMPOSE_FILE" ps --services); do
  container_name=$(docker compose -f "$COMPOSE_FILE" ps -q "$service")

  health_status=$(docker inspect --format='{{.State.Health.Status}}' "$container_name" 2>/dev/null || echo "none")

  if [[ "$health_status" == "none" ]]; then
    echo "ℹ️  $service has no healthcheck, skipping..."
    continue
  fi

  until [[ "$(docker inspect --format='{{.State.Health.Status}}' "$container_name")" == "healthy" ]]; do
    echo "⏳  Waiting for $service to become healthy..."
    sleep 1
  done

  echo "✅  $service is healthy."
done

echo "🚀  All ready. Dev infra is up and running!"
