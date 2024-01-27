package com.alexandervbarkov.cleanarchitecture.commoncore.mergepatch;

public interface MergePatches {
    <T> T mergePatch(T objectToPatch, String jsonMergePatch);
}
