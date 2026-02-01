# ChatOGT

### Online Gossip Transport Software

ChatOGT is a Kotlin-based, event-driven chat backend built around **clean architecture**, **DDD principles**, and a strong separation of bounded contexts.

At its core, ChatOGT focuses on one thing: **reliably transporting conversations, events, and intent between users and chats** — without coupling the system to specific delivery mechanisms or implementations.

---

## 🧠 What does OGT mean?

**OGT** stands for **Online Gossip Transport**:

* **Online** – designed for distributed, networked systems
* **Gossip** – chats, messages, and domain events flowing between users
* **Transport** – the infrastructure and orchestration that moves those events safely and predictably

---

## 🧩 Architecture Overview

* **Monorepo** managed with **Gradle (Kotlin DSL)** using **composite builds**
* Clear **bounded contexts** (e.g. `users`, `chats`)
* Shared modules split into:

    * `shared:domain`
    * `shared:infrastructure`
* Strong preference for **interfaces over implementations**
* Event-first design (aggregates are rehydrated from events)

---

## ⚙️ Tech Stack

* Kotlin
* Spring Boot
* Event-driven communication
* Sockets / transport abstractions (non-JSON-friendly)
* Time handling via `Instant`

---

## 🎯 Goals

* Keep domain logic pure and framework-agnostic
* Avoid circular dependencies between modules
* Make transport replaceable (today sockets, tomorrow something else)
* Stay boring where it matters, flexible where it counts

---

## 🚧 Status

Work in progress. APIs, transports, and boundaries are actively evolving.

Expect refactors. Embrace them.
