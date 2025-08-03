#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/../../" && pwd)"

COMPOSE_FILE="$REPO_ROOT/tools/docker/compose/docker-compose.yml"
PROJECT_NAME="chatogt-dev-infra"

# Check if any containers are running or exist for the project
container_count=$(docker ps -a --filter "label=com.docker.compose.project=$PROJECT_NAME" -q | wc -l)

if [[ "$container_count" -eq 0 ]]; then
  echo "ℹ️  No development infrastructure containers are running or exist for project '$PROJECT_NAME'. Nothing to stop."
  exit 0
fi

echo "🛑 Stopping development infrastructure..."

docker compose -p "$PROJECT_NAME" -f "$COMPOSE_FILE" down --remove-orphans

echo "✅  All dev containers stopped and removed."
echo "ℹ️  Note: Docker volumes have NOT been removed and data is preserved."
