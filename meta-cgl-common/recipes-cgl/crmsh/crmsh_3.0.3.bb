SUMMARY = "Pacemaker command line interface for management and configuration"
DESCRIPTION = "crm shell, a Pacemaker command line interface for management and configuration"

HOMEPAGE = "https://crmsh.github.io"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "asciidoc-native \
           docbook-xsl-stylesheets-native \
           libxslt-native \
           python-setuptools-native \
           "
RDEPENDS_${PN} = "pacemaker python-lxml gawk bash"

S = "${WORKDIR}/git"
SRC_URI = "git://github.com/ClusterLabs/${BPN}.git;branch=crmsh-3.0 \
           file://tweaks_for_build.patch \
          "

SRCREV = "41845ca5511b844593cf25ae4eb7f307aa78c5be"

inherit autotools-brokensep distutils-base

export HOST_SYS
export BUILD_SYS

# Allow to process DocBook documentations without requiring
# network accesses for the dtd and stylesheets
export SGML_CATALOG_FILES = "${STAGING_DATADIR_NATIVE}/xml/docbook/xsl-stylesheets/catalog.xml"

FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}/${BPN}"
