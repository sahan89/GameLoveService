## *Overview*
Sample GameLoveService Application assignment for ComeOn.

## *Prerequisites*
* Java 1.8
* Maven
* H2 DB
* Spring Boot
* Hibernate Data JPA


## *Run Project*

Save Game POST Request ```http://localhost:8085/api/saveGame```

`{
    "name": "IGI"
}`

Save Player POST Request ```http://localhost:8085/api/savePlayer```

`{
    "name": "Bela"
}`


Save Player POST Request ```http://localhost:8085/api/savePlayer```

`{
    "name": "Bela"
}`


Save Love Game POST Request ```http://localhost:8085/api/unloveGame```

`{
     "playerId":7,
     "gameId": 4
 }`


Unlove Game DELETE Request ```http://localhost:8085/api/lovedGame```

`{
    "playerId":7,
    "gameId": 3
}`

Get Player Loved Games GET Request ```http://localhost:8085/api/playerLovedGames/?playerId=7```

Get Most Loved Games GET Request ```http://localhost:8085/api/mostLoved?topCount=2```


