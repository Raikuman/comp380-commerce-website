# Sharingan E-Commerce Website
A COMP 380 Naruto-themed e-commerce website

Check out our [Trello here](https://trello.com/b/Yb0DRvci/e-commerce-website "Sharingan E-Commerce")

## Internals
What are we using?

1. Using Java Spring to expose endpoints using a Tomcat server
2. Using Spring's internal HikariCP JDBC libraries to connect to our AWS RDS mySQL cloud database
3. Using NuxtJS framework for the frontend

## Running the backend
Our backend can be run with either a compiled `.jar` with a `Start.bat` file, or taking the code from this github
and running in an IDE

Running the backend on your own computer will need permission by the repo owners as our database can only be accessed by us

## Running the frontend
Files found in the `/frontend` directory in our repo need to be placed in a pre-existing NuxtJS installation

Prerequisite: NodeJS latest version

1. In your command prompt or terminal, run the command `npx create-nuxt-app frontend`
2. `Project name: (frontend)` Just press enter here
3. `Programming language: JavaScript`
4. `Package manager: Npm`
5. `UI framework: None`
6. `Nuxt.js modules: Axios` Select ONLY Axios from the list
7. `Linting tools: None` Just press enter here without selecting any options
8. `Testing framework: None`
9. `Rendering mode: Universal (SSR / SSG)`
10. `Deployment target: Server (Node.js hosting)`
11. `Development tools: jsconfig.json`
12. `What is your Github username?` Enter your GitHub username, though we won't be using Git for the frontend
13. `Version control system: None`

From here, npm will install all the required modules for the frontend

Though, there are still additional modules that need to be installed:

1. `npm install node-sass@4.14.1`
2. `npm install sass-loader@10.1.1`

Afterwards, add all the files from the `/frontend` directory from our repo to the frontend NuxtJS project folder

In your command prompt or terminal, go to your new NuxtJS frontend directory and run the command `npm run dev`

NOTE: Running the frontend requires running the backend concurrently
NOTE: To stop running the frontend, in the command prompt or terminal use `CTRL + C` to stop the server
