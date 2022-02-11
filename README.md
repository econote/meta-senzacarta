# meta-senzacarta

SenzaCarta Yocto Project for SCV1 and SCV4 Boards

## How to compile and use software for SenzaCarta

Here you will find some basic info about how to start with YOCTO and SenzaCarta. If you follow the steps below, you should be able to compile the source code.  

In case you would like to know more about YOCTO and How to use it, for example: How to create, modify, compile, and use `meta-senzacarta`, kindly contact the MAINTAINER of the layer Vikrant A. P. <vikrant.ap@econote.in>  

### 1) Install the repo utility

    $ mkdir ~bin
    $ curl https://storage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
    $ chmod a+x ~/bin/repo

add following line to the `.bashrc` file to ensure that the `~/bin` folder is in your `PATH` variable  
    
    $ PATH=${PATH}:~/bin

### 2) Get the YOCTO Project with SenzaCarta support

    $ git config --global user.name "Your Name"
    $ git config --global user.email "Your Email"
    $ git config --list
    $ cd
    $ mkdir sc-yocto-bsp
    $ repo init -u https://github.com/econote/sc-yocto-base -b hardknott

### 3) Sync repositories

    $ repo sync

### 4) Add SenzaCarta meta layer into BSP

    $ source senzacarta-setup-release.sh

# Building Images

    $ cd ~/sc-yocto-bsp
    $ repo sync

### Currently Supported machines `<MACHINE>`
Here is a list of 'machine names' whcih you can use to build SenzaCarta images. Use the 'machine name' based on the board you have:

    imx7dsenzacarta

### Setup and Build Console image

    $ DISTRO=fsl-imx-fb MACHINE=imx7dsenzacarta source senzacarta-setup-release -b build-sc
    $ bitbake core-image-base

### Setup and Build Toolchain

    $ bitbake core-image-base -c populate_sdk

All repositories regarding U-boot and Linux Kernal maintained separately by SenzaCarta Team
