FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "libxml2"

PACKAGECONFIG_append = " libass libbluray libfreetype librtmp libvorbis \
                        mp3lame openjpeg openssl vpx wavpack"

PACKAGECONFIG[libass] = "--enable-libass,--disable-libass,libass"
PACKAGECONFIG[libbluray] = "--enable-libbluray --enable-protocol=bluray,--disable-libbluray,libbluray"
PACKAGECONFIG[libfreetype] = "--enable-libfreetype,--disable-libfreetype,freetype"
PACKAGECONFIG[librtmp] = "--enable-librtmp,--disable-librtmp,librtmp rtmpdump"
PACKAGECONFIG[openjpeg] = "--enable-libopenjpeg,--disable-libopenjpeg,openjpeg"
PACKAGECONFIG[wavpack] = "--enable-libwavpack,--disable-libwavpack,wavpack"

MIPSFPU = "${@bb.utils.contains('TARGET_FPU', 'soft', '--disable-mipsfpu', '--enable-mipsfpu', d)}"

SRC_URI_append += " \
	file://4_02_fix_mpegts.patch \
	file://4_03_allow_to_choose_rtmp_impl_at_runtime.patch \
	file://4_04_hls_replace_key_uri.patch \
	file://4_05_fix-hls.patch \
	file://4_07_increase_buffer_size.patch \
	file://4_09_ffmpeg_fix_edit_list_parsing.patch \
	file://4_10_rtsp_patch \
	file://4_11_dxva2_patch \
        file://4_A00-amf-h264-loop.patch \
        file://4_A02-corrupt-h264-frames.patch \
        file://4_A05-mov-read-name-track-tag-written-by-movenc.patch \
        file://4_A06-movenc-write-3gpp-track-titl-tag.patch \
        file://4_A07-mov-read-3gpp-udta-tags.patch \
        file://4_A08-movenc-write-3gpp-track-names-tags-for-all-available.patch \
	file://4_A11-FFmpeg-devel-amfenc-Add-support-for-pict_type-field.patch \
	file://4_A13-qsv-dx11.patch \
	"

EXTRA_FFCONF = " \
    --prefix=${prefix} \
    --disable-static \
    --enable-small \
    --disable-runtime-cpudetect \
    --enable-ffprobe \
    --disable-altivec \
    --disable-amd3dnow \
    --disable-amd3dnowext \
    --disable-mmx \
    --disable-mmxext \
    --disable-sse \
    --disable-sse2 \
    --disable-sse3 \
    --disable-ssse3 \
    --disable-sse4 \
    --disable-sse42 \
    --disable-avx \
    --disable-xop \
    --disable-fma3 \
    --disable-fma4 \
    --disable-avx2 \
    --enable-inline-asm \
    --enable-asm \
    --disable-x86asm \
    --disable-fast-unaligned \
    --enable-muxers \
    --enable-encoders \
    --enable-decoders \
    --enable-demuxers \
    --enable-parsers \
    --enable-bsfs \
    --enable-protocols \
    --enable-indevs \
    --enable-outdevs \
    --enable-filters \
    --disable-doc \
    --enable-libfdk-aac \
    --enable-encoder=libfdk_aac \
    --disable-htmlpages \
    --disable-manpages \
    --disable-podpages \
    --disable-txtpages \
    --disable-debug \
    --enable-zlib \
    ${@bb.utils.contains("TARGET_ARCH", "mipsel", "${MIPSFPU} --disable-vfp --disable-neon --disable-mipsdsp --disable-mipsdspr2", "", d)} \
    ${@bb.utils.contains("TARGET_ARCH", "arm", "--enable-armv6 --enable-armv6t2 --enable-vfp --enable-neon", "", d)} \
    ${@bb.utils.contains("TUNE_FEATURES", "aarch64", "--enable-armv8 --enable-vfp --enable-neon", "", d)} \
    --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS} -ffunction-sections -fdata-sections -fno-aggressive-loop-optimizations" \
    --extra-ldflags="${TARGET_LDFLAGS},--gc-sections -Wl,--print-gc-sections,-lrt" \
"
