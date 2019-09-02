DESCRIPTION = "libwww-perl provides a simple and consistent API to the World Wide Web"
HOMEPAGE = "https://metacpan.org/release/libwww-perl"
SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=225d44a95fa3addb1da6d91187ab189f"
DEPENDS = "liburi-perl-native libhtml-parser-perl-native libhtml-tagset-perl-native"
RDEPENDS_${PN} += " \
	libhtml-parser-perl \
	libhtml-tagset-perl \
	liburi-perl \
	perl-module-digest-md5 \
	perl-module-net-ftp \
	"
BBCLASSEXTEND = "native"

PR = "r2"

SRC_URI = "https://cpan.metacpan.org/authors/id/E/ET/ETHER/libwww-perl-${PV}.tar.gz;name=libwww-perl-${PV}"
SRC_URI[libwww-perl-6.36.md5sum] = "20062717e4084d2f56d84c7ab4c91ec1"
SRC_URI[libwww-perl-6.36.sha256sum] = "75c034ab4b37f4b9506dc644300697505582cf9545bcf2e2079e7263f675290a"

S = "${WORKDIR}/libwww-perl-${PV}"

inherit cpan
