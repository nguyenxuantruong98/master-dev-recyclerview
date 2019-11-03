package com.truong.btvnmasterdev;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.security.ProtectionDomain;
import java.util.List;

public class Genre extends ExpandableGroup<item2> {
    public Genre(String title, List<item2> items) {
        super(title, items);
    }
}
