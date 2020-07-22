FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
	"

RRECOMMENDS_${PN} = " \
	tzdata enigma2-plugin-skins-satdreamgr-hd-transpba \
	glib-networking \
	hotplug-e2-helper \
	glibc-gconv-utf-16 \
	python-sendfile \
	"

do_install_append() {
	if [ "${base_libdir}" = "/lib64" ] ; then
		install -d ${D}/usr/lib
		ln -s ${libdir}/enigma2 ${D}/usr/lib/enigma2
		ln -s ${libdir}/python2.7 ${D}/usr/lib/python2.7
	fi
}

FILES_${PN} += "/usr/lib"

do_openpli_branding() {
	if [ -n "${BRANDINGDIR}" -a -d "${BRANDINGDIR}/enigma2" ] ; then
		cp -r --preserve=mode,links ${BRANDINGDIR}/enigma2/* ${S}/data/
	fi
}

addtask openpli_branding after do_unpack before do_configure

