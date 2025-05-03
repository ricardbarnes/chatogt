rootProject.name = "chatogt"

include(
    // Shared libraries
    ":shared:domain",
    ":shared:infrastructure",

    // User Management Bounded Context
    ":usermanagement:domain:core",
    ":usermanagement:domain:application",
    ":usermanagement:api",
    ":usermanagement:producer",
    ":usermanagement:consumer",

    // Chat Bounded Context
    ":chat:domain:core",
    ":chat:domain:application",
    ":chat:api",
    ":chat:producer",
    ":chat:consumer",
    ":chat:shared",
)
