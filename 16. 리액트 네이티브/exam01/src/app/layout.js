import { Inter } from "next/font/google";
import "./globals.css";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
  /*head 태그 안쪽에 치환 */
  title: "제목",
  description: "설명",
};

//반드시 props에 children 정의해야 함
export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>
        <h1>상단</h1>
        <main>{children}</main>
        <h1>하단</h1>
      </body>
    </html>
  );
}
