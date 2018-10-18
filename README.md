# UtilityCode

[![Build Status](https://travis-ci.org/KilianB/UtilityCode.svg?branch=master)](https://travis-ci.org/KilianB/UtilityCode)
[ ![Download](https://api.bintray.com/packages/kilianb/maven/UtilityCode/images/download.svg) ](https://bintray.com/kilianb/maven/UtilityCode/_latestVersion)

Selection of java utility methods used in almost all projects.

## Maven, Gradle, Ivy

Distributed via Bintray 
``` XML
	<repositories>
		<repository>
			<id>jcenter</id>
			<url>https://jcenter.bintray.com/</url>
		</repository>
	</repositories>
	
	<dependencies>
		<dependency>
			<groupId>com.github.kilianB</groupId>
			<artifactId>UtilityCode</artifactId>
			<version>1.0.0</version>
		</dependency>
	</dependencies>
```

<details>
<summary>Gradle</summary>
<code>compile 'com.github.kilianB:UtilityCode:1.0.0'</code>
</details>

<details>
<summary>Ivy</summary>
<code>
<dependency org='com.github.kilianB' name='UtilityCode' rev='1.0.0'>
  <artifact name='UtilityCode' ext='pom' ></artifact>
</dependency>
</code>
</details>


## Content

<table>
	<tr>
		<th></th>
		<th></th>
	</tr>
	<tr>
		<td>MiscUtil</td>
		<td>Get OS info/ Restart Java VM</td>
	</tr>
	<tr>
		<td>Require</td>
		<td>Input assertions similar to <code> Objects.requireNonNull()</code></td>
	</tr>
	<tr>
		<td>NetworkUtil</td>
		<td>Resolve Network adapter and socket helper</td>
	</tr>
	<tr>
		<td>Mutable</td>
		<td>Mutable Wrapper for boxed primitives</td>
	</tr>
	<tr>
		<td>StringUtil</td>
		<td>Center text, get length of integers ....</td>
	</tr>
	<tr>
		<td>Graphics</td>
		<td>Color Utilities, Distance, Average Color, Palettes</td>
	</tr>
	<tr>
		<td>ArrayUtil</td>
		<td>Fill, search validation, deep clone</td>
	</tr>
	<tr>
		<td>CryptoUtil</td>
		<td>AES en- and decryption</td>
	</tr>
	<tr>
		<td>MathUtil</td>
		<td>clamping, fractional part, double compare</td>
	</tr>
	<tr>
		<td>...</td>
		<td>Non daemon thread factory, circular hashmap, rescaling images, ...</td>
	</tr>
</table>
