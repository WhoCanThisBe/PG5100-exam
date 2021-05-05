# PG5100-exam

#### to run application in frontend, you need to have a postgres server on port 5432 with password `password` for local dev
- docker run -d -u postgres -e POSTGRES_PASSWORD=password -p 5432:5432 postgres:13




* [x] User: having info like name, surname, hashed-password, email, etc.
* [x] Movie: having info like title, director, year of release, etc.
* [x] Review: having info like the target movie, the actual review text, the user author, when the
  review was created
*  [x] create a user
*  [x] create/delete a movie
*  [x] add review to a movie, with a 1 to 5 star
*  [x] compute average of stars per movie
*  [x] retrieve all movies, sorted by average stars
*  [x] retrieve all reviews for a movie, sorted by either stars or creation time of the review

* [x] Write integration tests for each of the @Service classes, using JUnit and @SpringBootTest annotation. You
  should have at least one test for each of the public methods in those services. Enable the calculation of
  code coverage with JaCoCo.
  
* [x] Homepage: display all movies (info summaries). If the user is logged in, then display a welcome
  message. Each movie entry must show the average stars it has, and link to a “movie details”
  page.
    * [x] If the user is logged in, enable possibility to write a new review. A user can only write
          one review per movie.
      
* [x] User login/signup page:
  * [x] based on Spring Security and storing of user info on the SQL database. It
  * [x] should be possible to logout from any of the pages (e.g., via a button). 
  * [x] When a login/signup fails, you MUST show an error message.



I did requirements R1, R2 and almost all of R3 Did not manage to do R4 except one selenium test for login and logout. Nothing in part 5



