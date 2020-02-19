SUMMARY = "Enigma2 Software Defined Radio"
DESCRIPTION = "SDR for Enigma2 using rtl_fm and dab-cmdline command line tools"
SECTION = "multimedia"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "http://satdreamgr.com"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://setup.py;beginline=4;endline=4;md5=a340145d59ca0aca0ff7ec9adccdb556"
SRC_URI = "git://github.com/satdreamgr/SDGRadio.git;protocol=http"

S = "${WORKDIR}/git"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "2+git${SRCPV}"
PKGV = "2+git${GITPKGV}"

inherit distutils-openplugins

RDEPENDS_${PN} = "python-core rtl-sdr redsea dab-cmdline-sdgradio dab-cmdline-sdgradio-pcm dab-cmdline-sdgradio-wav"

#PACKAGES =+ "${PN}-src"
RDEPENDS_{PN}-src = "${PN}"
FILES_${PN}-src = "${libdir}/enigma2/python/Plugins/Extensions/SDGRadio/*.py"

