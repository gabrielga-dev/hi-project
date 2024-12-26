# Hi project

This is a simple project to test deploying a Spring Boot at [Render Platform](https://render.com/) at free tier.

**!!!ATTENTION!!!** If you are not using a linux/amd64 arch OS, you can **have problems**. So, try to follow this 
tutorial on linux.

To make this deploy you need to follow the steps below:

## **1. Create project's jar file**

To create this file you need to run the following maven command:

`mvn clean package`

It will clean the project and create a package for it.

## **2. Create a dockerfile**

First, you need to create a docker file that aims to the project's .jar file. You can copy the following content or 
check the [Dockerfile](./Dockerfile).

```
FROM openjdk:17-jdk-slim
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

## **3. Create docker image**

Now, with the docker file ready, you need to create a docker image from it. Run the following commando to do this:

`docker build -t <YOUR_PROJECT_NAME> .`

Where `<YOUR_PROJECT_NAME>` will be your project's name. In this example will be hi-project.


### **3.1 Test Docker image**
Once with the image created, you can test it. Run the following command to create a container with the created image.

`docker run -p 8080:8080 -d hi-project`

## **4. Create the image repository on docker hub**
First, go to [Dockerhub](https://hub.docker.com/) and go to yours repositories and create a new one. It's name can be 
anything, but I prefer to use the same name as this project.

Ps.: If you didn't the docker login locally, do it now by running `docker login`

## **5. Tag Docker image**
To tag your docker image, run the following command:

`docker tag <YOUR_PROJECT_NAME> <YOUR_USERNAME>/<YOUR_PROJECT_NAME>:<TAG>`

**<YOUR_USERNAME>** is your username on Dockerhub.

**\<TAG>** is the new tag you want to put in the image. Examples: 1.0, 2.0, 1.5, 2.3.7

## **6. Push your Docker image to Dockerhub**
To push your image to Dockerhub, just run:

`docker push <YOUR_USERNAME>/<YOUR_PROJECT_NAME>:<TAG>`

## **7. Deploy on Render**
With your docker image on dockerhub, you can now deploy your application in a PaaS. Here we are using 
[Render](https://render.com/).

First of all, create a new account (user a free tier if you don't want to spend much money now) and create a new project
for API service. Then, set the deployment option to docker image and put your docker image there.
Remember to user the following format:

`<YOUR_USERNAME>/<YOUR_PROJECT_NAME>:<TAG>`

After this, you can put some env variables and little configurations. Then, deploy it! It can take a little while to 
pull all needed information.

Obs.: With spring boot the port detection is automatic, so you don´t need to set any env variable to set up the port.

## **8. Consume the deployed application**
Render will show you the URL to you deployed application. So just copy it and use it!

Ps.: If you want to use my deployment, run the following curl:

`curl 'https://hi-project-1-0.onrender.com/get-hi'`

If it is taking a long time, just wait! All free tier deployment will enter into a "sleep mode" when it's not consumed 
for too long. 