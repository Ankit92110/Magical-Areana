package org.example.commands;

import java.util.List;

public interface Icommand {
    void invoke(List<String> tokens);
}
