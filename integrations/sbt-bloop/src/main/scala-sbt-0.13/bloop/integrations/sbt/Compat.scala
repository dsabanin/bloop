package bloop.integrations.sbt

import bloop.config.Config
import sbt.{Def, Artifact, Keys}
import java.io.File

object Compat {
  implicit def fileToRichFile(file: File): sbt.RichFile = new sbt.RichFile(file)

  def generateCacheFile(s: sbt.Keys.TaskStreams, id: String) = s.cacheDirectory / id

  def toBloopArtifact(a: Artifact, f: File): Config.Artifact = {
    Config.Artifact(a.name, a.`type`, a.extension, a.classifier, None, f.toPath)
  }
}
