package com.btk5h.skriptmirror.skript.custom.condition;

import com.btk5h.skriptmirror.Util;
import com.btk5h.skriptmirror.skript.custom.CustomSyntaxSection;

import java.io.File;
import java.util.Objects;

class SyntaxInfo implements CustomSyntaxSection.SyntaxData {
  private final File script;
  private final String pattern;
  private final boolean inverted;
  private final boolean property;

  private SyntaxInfo(File script, String pattern, boolean inverted, boolean property) {
    this.script = script;
    this.pattern = pattern;
    this.inverted = inverted;
    this.property = property;
  }

  public static SyntaxInfo create(File script, String pattern, boolean inverted, boolean property) {
    return new SyntaxInfo(script, Util.preprocessPattern(pattern), inverted, property);
  }

  @Override
  public File getScript() {
    return script;
  }

  @Override
  public String getPattern() {
    return pattern;
  }

  public boolean isInverted() {
    return inverted;
  }

  public boolean isProperty() {
    return property;
  }

  @Override
  public String toString() {
    return String.format("%s (inverted: %s, property: %s)", pattern, inverted, property);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SyntaxInfo that = (SyntaxInfo) o;
    return inverted == that.inverted &&
        Objects.equals(pattern, that.pattern);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pattern, inverted);
  }
}
