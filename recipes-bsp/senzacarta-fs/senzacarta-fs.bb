# Copyright (C) 2022 SenzaCarta

SUMMARY = "SenzaCarta FileSyestem"
DESCRIPTION = "SenzaCarta FileSystem"
# FIXME - add proper license below
LICENSE = "CLOSED"

PV = "1.0"

S = "${WORKDIR}"

#inherit allarch
RDEPENDS_${PN} = " libgcc libpng"

do_install() {
    install -d ${D}/home/root/Documents
    install -d ${D}/home/root/Downloads
    install -d ${D}/home/root/.local

    install -d ${D}/home/root/.local/bin
    install -d ${D}/home/root/.local/lib
    install -d ${D}/home/root/.local/share

    install -d ${D}/home/root/.local/lib/senzacarta

    install -d ${D}/home/root/.local/lib/senzacarta/icons
    install -d ${D}/home/root/.local/lib/senzacarta/jar

    install -d ${D}/home/root/.local/share/reading
    install -d ${D}/home/root/.local/share/writing
    install -d ${D}/home/root/.local/share/sketching
}

FILES_${PN} += "/home/root/Documents"
FILES_${PN} += "/home/root/Downloads"
FILES_${PN} += "/home/root/.local"

FILES_${PN} += "/home/root/.local/bin"
FILES_${PN} += "/home/root/.local/lib"
FILES_${PN} += "/home/root/.local/share"

FILES_${PN} += "/home/root/.local/lib/senzacarta"

FILES_${PN} += "/home/root/.local/lib/senzacarta/icons"
FILES_${PN} += "/home/root/.local/lib/senzacarta/jar"

FILES_${PN} += "/home/root/.local/share/reading"
FILES_${PN} += "/home/root/.local/share/writing"
FILES_${PN} += "/home/root/.local/share/sketching"
