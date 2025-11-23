rootProject.name = "chatogt"

include(
    ":shared:domain",
    ":shared:infrastructure",

    ":usermanagement:domain:core",
    ":usermanagement:domain:application",
    ":usermanagement:api",
    ":usermanagement:producer",
    ":usermanagement:consumer",
    ":usermanagement:shared",

    ":chat:domain:core",
    ":chat:domain:application",
    ":chat:api",
    ":chat:producer",
    ":chat:consumer",
    ":chat:shared",
)
