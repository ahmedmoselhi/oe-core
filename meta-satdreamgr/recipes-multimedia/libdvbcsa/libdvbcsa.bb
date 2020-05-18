SUMMARY = "Open implementation of the DVB Common Scrambling Algorithm, encrypt and decrypt "
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRCREV = "81e4cd0875a9767c57e661bf4dfe89190221971b"

PV = "1.1.0"
PR = "r2"

SRC_URI = "git://github.com/Toysoft/libdvbcsa-patched.git;protocol=https \
"

S = "${WORKDIR}/git"

inherit autotools lib_package pkgconfig

do_install_append() {
    install -d ${D}${includedir}/dvbcsa/
    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${S}/src/dvbcsa/dvbcsa.h ${D}${includedir}/dvbcsa/
}
