# Copyright (C) 2012-2016 O.S. Systems Software LTDA.
# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRCBRANCH = "imx_5.4.24_2.1.0"
IMXTEST_SRC ?= "git://source.codeaurora.org/external/imx/imx-test.git;protocol=https"
SRC_URI = " \
    ${IMXTEST_SRC};branch=${SRCBRANCH} \
    file://0001-pxp-test-Fix-format-security-error.patch \
    file://memtool_profile \
"

SRCREV = "c856132f0fe812224eafea49b4cd0b05350742ad"

PACKAGECONFIG_append_mx8m = " swpdm"

PACKAGECONFIG[swpdm] = "HAS_IMX_SW_PDM=true,HAS_IMX_SW_PDM=false,imx-sw-pdm"

do_compile() {
    CFLAGS="${TOOLCHAIN_OPTIONS}"
    oe_runmake V=1 VERBOSE='' \
               CROSS_COMPILE=${TARGET_PREFIX} \
               CC="${CC} ${LDFLAGS} \
                    -I${S}/include \
                    -I${STAGING_INCDIR_IMX} \
                    -I${STAGING_INCDIR} \
                    -L${STAGING_LIBDIR}" \
               SDKTARGETSYSROOT=${STAGING_DIR_HOST} \
               LINUXPATH=${STAGING_KERNEL_DIR} \
               KBUILD_OUTPUT=${STAGING_KERNEL_BUILDDIR} \
               PLATFORM=${PLATFORM}
}
