FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
			file://opkg-configure.service \
			file://opkg.conf \
			file://modprobe \
"
