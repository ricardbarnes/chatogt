rootProject.name = "chatogt"

include(
    ":shared:domain",
    ":shared:infrastructure",

    ":users:domain:core",
    ":users:domain:application",
    ":users:api",
    ":users:producer",
    ":users:consumer",

    ":chats:domain:core",
    ":chats:domain:application",
    ":chats:api",
    ":chats:producer",
    ":chats:consumer",
    ":chats:shared",
)
