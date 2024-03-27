import React from "react";
import { navMenu } from "./navMenu";

export default function Navigation() {
  return (
    <div className="h-screen sticky top-0">
      <div>
        <div className="py-5">
          <img
            height={35}
            width={35}
            src="https://cdn.pixabay.com/photo/2023/06/01/09/20/cartoon-8033257_640.png"
            alt="Logo"
          />
        </div>
        <div className="space-y-6">
          {navMenu.map((item, index) => (
            <div
              key={index}
              className="cursor-pointer flex space-x-3 items-center"
            >
              {item.icon && <item.icon className="icon-class" />}
              <p className="text-xl">{item.title}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
