<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="algebra">
		<html>
			<xsl:variable name="n1">
				<xsl:value-of select="number1" />
			</xsl:variable>

			<xsl:variable name="n2">
				<xsl:value-of select="number2" />
			</xsl:variable>
			
			<div>
			<xsl:value-of select="$n1" /> + <xsl:value-of select="$n2" />
				= <xsl:value-of select="$n1 + $n2" />
			</div>
			
			<div>
			<xsl:value-of select="($n1 * $n2 + $n1 div $n2) div ($n1 + $n2)" />
			</div>
			
		</html>
	</xsl:template>
</xsl:stylesheet>