# mmr

## Usage

To use it in a Maven project, add the following to pom.xml:

```xml
<repositories>
        <repository>
            <id>mmr-mvn-repo</id>
            <url>https://raw.github.com/nikalsh/mmr/mvn-repo/</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>
```
```xml
  <dependency>
            <groupId>com.patchwerk</groupId>
            <artifactId>mmr</artifactId>
            <version>1.0-SNAPSHOT</version>
  </dependency>
```
