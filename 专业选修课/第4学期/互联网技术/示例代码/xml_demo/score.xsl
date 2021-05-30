<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="Classes">
		<html>
			<table>
				<xsl:for-each select="Class">
					<tr>
						<td><xsl:value-of select="name" /></td>
						<td><xsl:value-of select="hours" /></td>
						<td><xsl:value-of select="score" /></td>
					</tr>
				</xsl:for-each>
				<tr><td>加权平均</td><td>
					<xsl:call-template name="calculate_score">
						<xsl:with-param name="pre_sum">0</xsl:with-param>
						<xsl:with-param name="last_node">
							<xsl:value-of select="number(count(Class))" />
						</xsl:with-param>
					</xsl:call-template>
				</td></tr>
			</table>
		</html>
	</xsl:template>

	<xsl:template name="calculate_score">
		<xsl:param name="pre_sum" />
		<xsl:param name="last_node" />

		<xsl:variable name="ass_score" 
			select="Class[number($last_node)]/hours * Class[number($last_node)]/score" />

		<xsl:variable name="curr_sum" select="number($pre_sum + $ass_score)" />

		<xsl:choose>
			<xsl:when test="number($last_node -1) &gt; 0">
				<xsl:call-template name="calculate_score">
					<xsl:with-param name="pre_sum"><xsl:value-of select="$curr_sum" /></xsl:with-param>
					<xsl:with-param name="last_node"><xsl:value-of select="number($last_node -1)" /></xsl:with-param>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="format-number($curr_sum div sum(Class/hours),'#0.000')" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

</xsl:stylesheet>