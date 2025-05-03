rootProject.name = "chatogt"

include(
    // Shared libraries
    ":shared:domain",
    ":shared:infrastructure",

    // Users Bounded Context
    ":users:domain:core",
    ":users:domain:application",
    ":users:api",
    ":users:producer",
    ":users:consumer",

    // Chats Bounded Context
    ":chats:domain:core",
    ":chats:domain:application",
    ":chats:api",
    ":chats:producer",
    ":chats:consumer",
    ":chats:shared",
)
