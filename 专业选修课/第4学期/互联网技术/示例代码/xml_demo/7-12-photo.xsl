<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <body>
        <xsl:apply-templates />
      </body>
    </html>
  </xsl:template>
  <xsl:template match="StudentList">
    <Table border="3">
      <TR>
        <TD>学号</TD>
        <TD>姓名</TD>
        <TD>计算机</TD>
        <TD>英语</TD>
        <TD>文学</TD>
        <TD>哲学</TD>
        <td>平均分</td>
      </TR>
      <xsl:apply-templates/>
    </Table>
  </xsl:template>
  <xsl:template match="StudentList/Student">
    <TR>
      <TD>
        <xsl:value-of select="ID"/>
      </TD>
      <TD>
        <xsl:value-of select="Name"/>
      </TD>
      <xsl:apply-templates select="Mark"/>
    </TR>
  </xsl:template>
  <xsl:template match="/StudentList/Student/Mark">
    <TD>
      <xsl:variable name="test1" select="Computer"/>
      <xsl:value-of select="$test1"/>
    </TD>
    <TD>
      <xsl:variable name="test2" select="English"/>
      <xsl:value-of select="$test2"/>
    </TD>
    <TD>
      <xsl:variable name="test3" select="Literature"/>
      <xsl:value-of select="$test3"/>
    </TD>
    <TD>
      <xsl:variable name="test4" select="Philosophy"/>
      <xsl:value-of select="$test4"/>
    </TD>
    <td>
      <xsl:element name="img">
        <xsl:attribute name="src">
          <xsl:value-of select="../Photo"/>
        </xsl:attribute>
      </xsl:element>
    </td>
    <td>
      <xsl:value-of select="($test1 + $test2 + $test3 + $test4) div 4"/>
    </td>
  </xsl:template>
</xsl:stylesheet>
