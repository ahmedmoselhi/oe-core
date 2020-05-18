PACKAGES =+ "${PN}-realpath ${PN}-truefalse"

FILES_${PN}-truefalse = "${base_bindir}/true.${PN} ${base_bindir}/false.${PN}"
FILES_${PN}-realpath = "${bindir}/realpath.${PN}"

RRECOMMENDS_${PN}_append_class-target = "${PN}-realpath ${PN}-truefalse"

ALTERNATIVE_${PN}_remove = "realpath true false"
ALTERNATIVE_${PN}-truefalse = "true false"
ALTERNATIVE_${PN}-realpath = "realpath"