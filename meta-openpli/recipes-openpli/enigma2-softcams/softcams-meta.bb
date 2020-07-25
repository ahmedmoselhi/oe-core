SUMMARY = "meta file for enigma2 softcam packages"

require conf/license/license-gplv2.inc

PROVIDES = "openatv-softcams"

DEPENDS = ""

SOFTCAMS = "\
	enigma2-plugin-softcams-oscam-smod \
	enigma2-plugin-softcams-oscam-smod-ipv4only \
	enigma2-plugin-softcams-oscam-emu \
	enigma2-plugin-softcams-oscam-emu-ipv4only \
	enigma2-plugin-softcams-oscam-stable \
	enigma2-plugin-softcams-oscam-stable-ipv4only \
	\
	enigma2-plugin-softcams-ncam \
	enigma2-plugin-softcams-ncam-ipv4only \
	\
        enigma2-plugin-softcams-wicardd \
	\
        enigma2-plugin-softcams-mgcamd \
	\
        enigma2-plugin-softcams-cccam \
"

SOFTCAMS_remove_cortexa9hf-neon = "enigma2-plugin-softcams-gbox"
SOFTCAMS_remove_cortexa9hf-neon = "enigma2-plugin-softcams-mgcamd"
SOFTCAMS_remove_cortexa9hf-neon = "enigma2-plugin-softcams-wicardd"
SOFTCAMS_remove_cortexa9hf-neon = "enigma2-plugin-softcams-cccam"

DEPENDS += "\
	${SOFTCAMS} \
"

PR = "r0"
