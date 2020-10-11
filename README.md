# Code Fellowship

- Connecting coders around the world!

## Instruction to Run the App

1. Go to [Github Repository](https://github.com/kuya32/codefellowship) and copy link from green Code dropdown under "clone."

2. Open up your terminal and navigate to location directory.

3. Run ``git clone <insert-Github-link>``

4. Now set up a Postgresql database named "fellows".

5. To connect the database, edit the "application.properties" file found in "src/main/resrouces".

6. In the "application.properties" file, replace information with your Postgres username and password.

7. After that, run ``.gradlew bootRun`` in your terminal and open up [http://localhost:8080](http://localhost:8080) in your browser.
