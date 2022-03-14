# Copyright (C) 2020 SenzaCarta

SUMMARY = "LibreBaskerville TrueType Fonts"
DESCRIPTION = "adding LibreBaskerville TrueType Fonts inside the SenzaCarta RootFS"
# FIXME - add proper license below
LICENSE = "CLOSED"

SRC_URI = " file://LibreBaskerville-Bold.ttf\
			file://LibreBaskerville-Italic.ttf \
			file://LibreBaskerville-Regular.ttf \
			"

PV = "1.0"

S = "${WORKDIR}"

inherit allarch

do_install() {
	install -d ${D}/usr/share/fonts/truetype

	install -m 0644 ${WORKDIR}/LibreBaskerville-Bold.ttf ${D}/usr/share/fonts/truetype/
	install -m 0644 ${WORKDIR}/LibreBaskerville-Italic.ttf ${D}/usr/share/fonts/truetype/
	install -m 0644 ${WORKDIR}/LibreBaskerville-Regular.ttf ${D}/usr/share/fonts/truetype/
}

FILES_${PN} += "/usr/share/fonts/truetype/LibreBaskerville-Bold.ttf"
FILES_${PN} += "/usr/share/fonts/truetype/LibreBaskerville-Italic.ttf"
FILES_${PN} += "/usr/share/fonts/truetype/LibreBaskerville-Regular.ttf"
