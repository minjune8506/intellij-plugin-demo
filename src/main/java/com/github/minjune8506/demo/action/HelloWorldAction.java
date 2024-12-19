package com.github.minjune8506.demo.action;

import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class HelloWorldAction extends AnAction {

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        // when targeting intellij platform 2022.3 or later
        return ActionUpdateThread.BGT;
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        // using the event, evaluate the context, and enable or disable the cation
        // defaults always to enable this action

        var project = event.getProject();
        event.getPresentation().setEnabledAndVisible(project != null);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        // using the event, implement an action
        // for example, create and show dialog
        var currentProject = event.getProject();
        var message = new StringBuilder(event.getPresentation().getText() + " selected!");
        var selectedElement = event.getData(CommonDataKeys.NAVIGATABLE);
        if (selectedElement != null) {
            message.append("\nselected element: ").append(selectedElement);
        }
        var title = event.getPresentation().getDescription();
        Messages.showMessageDialog(
            currentProject,
            message.toString(),
            title,
            Messages.getInformationIcon());
    }
}
