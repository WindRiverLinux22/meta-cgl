require ${@bb.utils.contains("BBFILE_COLLECTIONS", "lsb", "recipes-lsb/images/core-image-lsb.bb", "recipes-core/images/core-image-base.bb", d)}


LSB_WARN ?= "1"
python () {
    lsb_warn = d.getVar("LSB_WARN")
    if bb.utils.contains("BBFILE_COLLECTIONS", "lsb", "1", "0", d) == "0" and lsb_warn == "1":
       bb.warn("CGL compliance requires lsb, and meta-lsb is not included.\n" + \
               "To disable this warning set LSB_WARN='0'")
}
      
VALGRIND ?= ""
VALGRIND:powerpc ?= "valgrind"
VALGRIND_e500v2 ?= ""
VALGRIND:x86 ?= "valgrind"
VALGRIND:x86_64 ?= "valgrind"
VALGRIND:armv7a ?= "valgrind"

# Include modules in rootfs
IMAGE_INSTALL += "\
    packagegroup-core-buildessential \
    packagegroup-core-selinux \
    packagegroup-cgl \
    kexec-tools \
    lttng-tools \
    lttng-modules \
    ${VALGRIND} \
    "

IMAGE_FSTYPES += " ext3.gz"

# kexec-tools doesn't work on Mips
KEXECTOOLS:mips ?= ""
KEXECTOOLS:mipsel ?= ""

IMAGE_FEATURES += "tools-debug tools-profile"
