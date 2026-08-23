# VaultMusic
Kotlin based offline music player built for multi-platform use. Built for fun to learn Kotlin.
(Work In Progress)

# Repository structure
I know it's a headache to create a package with DAOs used by a specific ORM/DB(especially for a personal
project), but maybe I or someone will decide to use another ORM.

If you want to modify the ORM/database change the following:
* **Create new Entities and Access Objects:** 
Build the new ORM's specific models and queries in a new package
(e.g., `repository/impl/orm/sqldelight/`).

* **Create new Mappers:** 
Write new mapping functions to translate the new ORM's data models into the pure Domain models.

* **Write new Repository Implementations:** 
Create new concrete classes (e.g.`SongRepositorySqlDelightImpl`) that implement the existing Domain 
Interfaces (`ISongRepository`). You do **not** need to touch the interfaces themselves.

* **Update Dependency Injection (Hilt):** 
Swap out the bindings in your DI module so it provides the new repository implementations instead of 
the Room ones.
  
Because the ViewModels and UI only speak to the Domain classes, the rest of theapplication will use 
the new database without needing to modify any other code.