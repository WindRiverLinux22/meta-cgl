SUMMARY = "Application packages required to satisfy the Carrier Grade Linux (CGL) specification"
DESCRIPTION = "This package group includes the application with which the user interacts \
               when using a Linux operation system."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup
inherit pkgconfig


PACKAGES = "${PN}"

LM_SENSORS = " \
    lmsensors-fancontrol \
    lmsensors-libsensors \
    lmsensors-pwmconfig \
    lmsensors-sensord \
    lmsensors-sensors \
    lmsensors-sensorsconfconvert \
    lmsensors-sensorsdetect \
    lmsensors-config-cgi \
    lmsensors-config-libsensors \
    lmsensors-config-sensord \
    lmsensors-config-fancontrol \
    "

RDEPENDS:${PN} = " \
    lvm2 \
    ${LM_SENSORS} \
    bc \
    gettext \
    gettext-runtime \
    babeltrace \
    gdb \
    gdbserver \
    rsync \
    strace \
    libevent \
    mdadm \
    quota \
    smartmontools \
    monit \
    ocfs2-tools \
    logcheck \
    samhain-client \
    samhain-server \
    audit \
    crash \
    makedumpfile \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pam', 'pam-passwdqc libpam', '', d)} \
    "

LTTNG ?= "\
    lttng-tools \
    lttng-modules \
    lttng-ust \
    "
LTTNG:armv6 ?= ""

LTTNGUST = "lttng-ust"
LTTNGUST_libc-uclibc = ""

RDEPENDS:${PN}:append:qemux86 = " valgrind lttng-ust"
RDEPENDS:${PN}:append:qemux86-64 = " ${LTTNGUST}"
RDEPENDS:${PN}:append:qemuppc = " ${LTTNGUST}"
RDEPENDS:${PN}:append:qemuarm = " ${LTTNGUST}"
RDEPENDS:${PN}:append:powerpc = " ${LTTNGUST}"

RRECOMMENDS:${PN} = ""
