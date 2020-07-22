##################
### SatDreamGR ###
##################

require ../../../meta-openpli/recipes-openpli/images/openpli-enigma2-image.bb

#PR = "r20200511"
PR = "r${DATE}"
#PR[vardepsexclude] = "DATE"

ENIGMA2_PLUGINS_remove = "enigma2-plugin-softcams-oscam"

IMAGE_INSTALL_remove = "openpli-bootlogo"
IMAGE_INSTALL_remove = "enigma2-plugin-extensions-ppanel"
IMAGE_INSTALL_remove = "enigma2-plugin-softcams-oscam"
IMAGE_INSTALL_remove = "3rd-party-feed-configs"

IMAGE_INSTALL += " \
	dabstreamer \
        python-service-identity \
	enigma2-plugin-extensions-backupsuite \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-foreca \
	enigma2-plugin-extensions-greeknetradio \
	enigma2-plugin-extensions-greekstreamtv \
	enigma2-plugin-extensions-sdgradio \
        enigma2-plugin-systemplugins-signalfinder \
	enigma2-plugin-extensions-xmltvimport-greekepg \
	enigma2-plugin-extensions-youtube \
	enigma2-plugin-softcams-oscam-smod \
	enigma2-plugin-softcams-oscam-emu \
	enigma2-plugin-softcams-ncam \
        enigma2-plugin-softcams-wicardd \
        enigma2-plugin-softcams-mgcamd \
        enigma2-plugin-softcams-cccam \
	enigma2-plugin-skins-satdreamgr-hd-transpba \
	enigma2-plugin-systemplugins-devicemanager \
	enigma2-plugin-systemplugins-mphelp \
	fuse-exfat \
	livestreamersrv \
	ntfs-3g \
	satdreamgr-bootlogo \
	satdreamgr-extra-feed-configs \
	satdreamgr-panel \
	softcam-support \
"

export KERNEL_VERSION = "${@oe.utils.read_file('${STAGING_KERNEL_BUILDDIR}/kernel-abiversion')}"

DEPENDS += " \
	astra-sm \
	enigma2-plugin-extensions-bitrate \
	enigma2-plugin-extensions-historyzapselector \
	enigma2-plugin-extensions-subssupport \
	enigma2-plugin-skins-octagoneightfhd \
	enigma2-plugin-skins-satdreamgr-hd \
	enigma2-plugin-systemplugins-crossepg \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugins \
	exteplayer3 \
	gstplayer \
	libcec \
	libtorrent \
	ntp \
	p7zip \
	satipclient \
"
