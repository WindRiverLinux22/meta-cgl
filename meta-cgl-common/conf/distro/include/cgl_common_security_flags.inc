SECURITY_LDFLAGS:remove:pn-audit = "-fstack-protector-strong"

SECURITY_CFLAGS:pn-ocfs2-tools = "${SECURITY_NOPIE_CFLAGS}"
SECURITY_LDFLAGS:pn-ocfs2-tools = ""

