<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Customers</title>
      </head>
      <body>
        <h1>Customers</h1>
        <table border = '1'>
          <tbody>
            <xsl:for-each select="customers/customer">
              <tr>
                <th>
                  <xsl:apply-templates select="name"/>
                </th>
                <xsl:for-each select="order">
                  <td>
                    <xsl:apply-templates/>
                  </td>
                </xsl:for-each>
              </tr>
            </xsl:for-each>
          </tbody>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
