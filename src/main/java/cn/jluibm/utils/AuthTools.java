package cn.jluibm.utils;

import cn.jluibm.model.entity.User;
import jdk.nashorn.internal.objects.NativeUint8Array;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthTools {

    enum PermissionType {
        Guest(0),
        Registered(1),
        Admin(2);

        private final int value;

        public int getValue() {
            return value;
        }

        PermissionType(int i) {
            value = i;
        }
    }

    public static User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();

        return (User) session.getAttribute("user");
    }

    public static PermissionType getPermission(HttpServletRequest request) {
        User user = getCurrentUser(request);

        if (user == null)
            return PermissionType.Guest;

        switch (user.getPermission()) {
            case 1:
                return PermissionType.Registered;
            case 2:
                return PermissionType.Admin;
            default:
                return PermissionType.Guest;
        }
    }
}
