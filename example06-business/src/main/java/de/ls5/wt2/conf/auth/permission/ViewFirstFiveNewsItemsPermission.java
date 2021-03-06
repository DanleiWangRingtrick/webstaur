package de.ls5.wt2.conf.auth.permission;

import java.util.List;

import de.ls5.wt2.entity.DBTodos;
import org.apache.shiro.authz.Permission;

public class ViewFirstFiveNewsItemsPermission implements Permission {

    private final List<DBTodos> news;

    public ViewFirstFiveNewsItemsPermission(final List<DBTodos> news) {
        this.news = news;
    }

    @Override
    public boolean implies(Permission p) {
        return false;
    }

    public boolean check() {
        return this.news.size() < 5;
    }
}
