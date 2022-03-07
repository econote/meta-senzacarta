# Copyright (C) 2022 SenzaCarta

SUMMARY = "U-Boot bootloader with support for SenzaCarta Board"

DESCRIPTION = "U-Boot bootloader with support for SenzaCarta Board. \
                Contact MAINTAINER for more support."

require recipes-bsp/u-boot/u-boot.inc
require u-boot-common.inc

PROVIDES += "u-boot"

UBOOT_SRC ?= "git://github.com/econote/u-boot-senzacarta.git;protocol=https"
SRCBRANCH = "v202104"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "96d5f330ba60154e7aa25bd944c6681492058e76"

LOCALVERSION = "-${SRCBRANCH}"

UBOOT_TAGGED_BINARY ?= "u-boot-tagged.${UBOOT_SUFFIX}"

deploy_tag() {
    # Append a tag to the bootloader image used in the SD card image
    cp ${UBOOT_BINARY} ${UBOOT_TAGGED_BINARY}
    ln -sf ${UBOOT_TAGGED_BINARY} ${UBOOT_BINARY}
    stat -L -cUUUBURNXXOEUZX7+A-XY5601QQWWZ%sEND ${UBOOT_BINARY} >> ${UBOOT_BINARY}
}

do_deploy_append_mx7() {
    deploy_tag
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx7|imx7dsenzacarta)"

UBOOT_NAME_mx7 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_imx7dsenzacarta = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
