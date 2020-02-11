<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/catalog">
		<html>
			<head>
				<style>
					table {
					font-family: arial, sans-serif;
					border-collapse: collapse;
					width:
					100%;
					}
					td, th {
					border: 1px solid #dddddd;
					text-align: left;
					padding: 8px;
					}
					tr:nth-child(even) {
					background-color: #dddddd;
					}
				</style>
			</head>
			<body>
				<h2>Books</h2>
				<table>
					<tr>
						<th>Id</th>
						<th>Author</th>
						<th>Title</th>
						<th>Genre</th>
						<th>Price</th>
						<th>Publish Date</th>
						<th>Description</th>
					</tr>
					<xsl:for-each select="book">
						<tr>
							<td>
								<xsl:value-of select="book/@id" />
							</td>
							<td>
								<xsl:value-of select="author" />
							</td>
							<td>
								<xsl:value-of select="title" />
							</td>
							<td>
								<xsl:value-of select="genre" />
							</td>
							<td>
								<xsl:value-of select="price" />
							</td>
							<td>
								<xsl:value-of select="publish_date" />
							</td>
							<td>
								<xsl:value-of select="description" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>