<?xml version="1.0" encoding="utf-8"?>
<!-- ====================================================================
	XSLT stylesheet to convert the main HTML help file for
	eTrice into Eclipse Table of Contents files.               

	Copyright (c) 2013 Frank Lippert
	All rights reserved. This program and the accompanying materials
	are made available under the terms of the Eclipse Public License v1.0
	which accompanies this distribution, and is available at 
	www.eclipse.org/legal/epl-v10.html

	CONTRIBUTORS:
		Frank Lippert (initial contribution)
	 ================================================================ --> 
<xsl:stylesheet 
	version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	
	xmlns:xhtml="http://www.w3.org/1999/xhtml"
	exclude-result-prefixes="xhtml xsl"
>

	<!-- ======================= create TOC documents ============================= -->
	<xsl:template match="/">
		<xsl:result-document indent="yes" method="xml" href="reference-toc.xml">
			<xsl:call-template name="ref_toc"/>
		</xsl:result-document>
	
		<xsl:result-document indent="yes" method="xml" href="top-toc.xml">
			<xsl:call-template name="top_toc"/>
		</xsl:result-document>
	
		<xsl:result-document method="xml" indent="yes" href="toc.xml" omit-xml-declaration="yes">
			<xsl:apply-templates select="xhtml:html/xhtml:body/xhtml:div[@class='tableofcontents']" />
		</xsl:result-document>
	</xsl:template>

	
	<!-- ======================= analyzing div element ============================ -->
	<xsl:template match="xhtml:div">
		<toc topic="etrice-doc.html" label="eTrice User Guide">
			<xsl:apply-templates select="xhtml:span"/>
		</toc>
	</xsl:template>

	
	<!-- ====================== analyzing span elements =========================== -->
	<xsl:template match="xhtml:span">
		<xsl:if test="./@class='chapterToc'">
			<xsl:variable name="chapter" select="."/>
			<xsl:element name="topic">
				<xsl:attribute name="href"><xsl:value-of select="xhtml:a/@href" /></xsl:attribute>
				<xsl:attribute name="label"><xsl:value-of select="xhtml:a" /></xsl:attribute>
				<xsl:for-each select="following-sibling::xhtml:span[@class='sectionToc'][preceding-sibling::xhtml:span[@class='chapterToc'][1] = $chapter]">
                    <xsl:element name="topic">
						<xsl:attribute name="href"><xsl:value-of select="xhtml:a/@href" /></xsl:attribute>
						<xsl:attribute name="label"><xsl:value-of select="xhtml:a" /></xsl:attribute>
					</xsl:element>
                </xsl:for-each>
			</xsl:element>
		</xsl:if>
	</xsl:template>

	
	<!-- ======================= creating top-level TOC =========================== -->
	<xsl:template name="top_toc">
		<xsl:processing-instruction name="NLS">
			TYPE="org.eclipse.help.toc"
		</xsl:processing-instruction>
		<toc label="eTrice Help" topic="html/toc.html">
			<link toc="toc.xml" />
			<link toc="reference-toc.xml" />
		</toc>
	</xsl:template>

	
	<!-- == creating reference TOC with link to JavaAPI documentation ============= -->
	<xsl:template name="ref_toc">
		<xsl:processing-instruction name="NLS">
			TYPE="org.eclipse.help.toc"
		</xsl:processing-instruction>
		<xsl:comment>
			<copyright>
   
		Copyright (c) 2011 protos software gmbh (http://www.protos.de).
		All rights reserved. This program and the accompanying materials
		are made available under the terms of the Eclipse Public License v1.0
		which accompanies this distribution, and is available at
		http://www.eclipse.org/legal/epl-v10.html
		 
		CONTRIBUTORS:
			Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
   
			</copyright>
		</xsl:comment>
		<toc label="eTrice Developer Guide">
			<topic href="html/javadoc/overview-summary.html" label="Reference"/>
		</toc>
	</xsl:template>

</xsl:stylesheet>
