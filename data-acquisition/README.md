1) Build an image using this docker file. Run the following docker command

    $ docker build -t qualichain/acquisition:v1.1.0 .

2) Test Fuhsen in a container. Run the following docker command for testing

    $ docker run --rm -it -p 9000:9000 --name acquisition qualichain/acquisition:v1.1.0 /bin/bash
