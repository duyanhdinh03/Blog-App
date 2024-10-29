package com.springboot.blog.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
  private String resourceName;
  private String fileName;
  private long fileValue;

  public ResourceNotFoundException(String resourceName, String fileName, long fileValue) {
    super(String.format("%s not found with %s : %s", resourceName, fileName, fileValue));
    this.resourceName = resourceName;
    this.fileName = fileName;
    this.fileValue = fileValue;
  }

  public String getResourceName() {
    return resourceName;
  }

  public long getFileValue() {
    return fileValue;
  }

  public String getFileName() {
    return fileName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public void setFileValue(long fileValue) {
    this.fileValue = fileValue;
  }

}
