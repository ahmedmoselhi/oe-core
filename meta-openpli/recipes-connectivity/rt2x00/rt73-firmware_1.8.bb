SUMMARY = "Firmware for rt73 based USB wifi adaptors"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.ralink-firmware.txt;md5=682eac07428a4e8f138bc082f090ecac"

SRC_URI = "http://ftp.is.co.za/mirror/ftp.slackware.com/pub/slackware-13.37/source/n/rt71w-firmware/RT71W_Firmware_V${PV}.zip"

S = "${WORKDIR}/RT71W_Firmware_V${PV}"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0644 rt73.bin ${D}${nonarch_base_libdir}/firmware/
}

FILES_${PN} = "${nonarch_base_libdir}/firmware/"

inherit allarch

SRC_URI[md5sum] = "1e7a5dc574e0268574fcda3fd5cf52f7"
SRC_URI[sha256sum] = "e2d3ac1aaf4815e0c9531bc3fb7f56f30604cd52351332f1f8d6a28bb9a953bf"
