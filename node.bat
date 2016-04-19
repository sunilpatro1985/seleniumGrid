title node1
cd C:\Grid
java -Dwebdriver.ie.driver="c:\Grid\IEDriverServer.exe"  -Dwebdriver.chrome.driver="c:\Grid\chromedriver.exe"  -Dwebdriver.firefox.bin="C:\Program Files (x86)\Mozilla Firefox\firefox.exe" -jar selenium-server-standalone-2.53.0.jar -role node -hub http://10.112.70.32:9500/grid/register -port 5551 -browser browserName=firefox -browser browserName=iexplorer -maxSession 10