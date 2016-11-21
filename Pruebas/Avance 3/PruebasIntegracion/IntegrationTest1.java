package PruebasIntegracion;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.opencv.core.Core;

import SegmentacionTemporal.ControladorSegmentador;

public class IntegrationTest1 {

	private static String pNombreVideo;
	
	ControladorSegmentador controlador = new ControladorSegmentador();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pNombreVideo = "C:\\Users\\juanj\\workspace\\SegmentacionTemporal\\src\\Video.MP4";
	}

	@Test
	public void test() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		String archivo = controlador.generarArchivoCortes(pNombreVideo);
		
		String resultadoesperado = "{\"data\":[{\"lastFrame\":270,\"eventType\":\"No Corte\",\"initialFrame\":0},{\"lastFrame\":271,\"eventType\":\"Corte\",\"initialFrame\":271},{\"lastFrame\":318,\"eventType\":\"No Corte\",\"initialFrame\":272},{\"lastFrame\":319,\"eventType\":\"Corte\",\"initialFrame\":319},{\"lastFrame\":456,\"eventType\":\"No Corte\",\"initialFrame\":320},{\"lastFrame\":457,\"eventType\":\"Corte\",\"initialFrame\":457},{\"lastFrame\":760,\"eventType\":\"No Corte\",\"initialFrame\":458},{\"lastFrame\":761,\"eventType\":\"Corte\",\"initialFrame\":761},{\"lastFrame\":962,\"eventType\":\"No Corte\",\"initialFrame\":762},{\"lastFrame\":963,\"eventType\":\"Corte\",\"initialFrame\":963},{\"lastFrame\":983,\"eventType\":\"No Corte\",\"initialFrame\":964},{\"lastFrame\":984,\"eventType\":\"Corte\",\"initialFrame\":984},{\"lastFrame\":993,\"eventType\":\"No Corte\",\"initialFrame\":985},{\"lastFrame\":994,\"eventType\":\"Corte\",\"initialFrame\":994},{\"lastFrame\":999,\"eventType\":\"No Corte\",\"initialFrame\":995},{\"lastFrame\":1000,\"eventType\":\"Corte\",\"initialFrame\":1000},{\"lastFrame\":1002,\"eventType\":\"No Corte\",\"initialFrame\":1001},{\"lastFrame\":1003,\"eventType\":\"Corte\",\"initialFrame\":1003},{\"lastFrame\":1005,\"eventType\":\"No Corte\",\"initialFrame\":1004},{\"lastFrame\":1006,\"eventType\":\"Corte\",\"initialFrame\":1006},{\"lastFrame\":1009,\"eventType\":\"No Corte\",\"initialFrame\":1007},{\"lastFrame\":1010,\"eventType\":\"Corte\",\"initialFrame\":1010},{\"lastFrame\":1011,\"eventType\":\"No Corte\",\"initialFrame\":1011},{\"lastFrame\":1012,\"eventType\":\"Corte\",\"initialFrame\":1012},{\"lastFrame\":1014,\"eventType\":\"No Corte\",\"initialFrame\":1013},{\"lastFrame\":1015,\"eventType\":\"Corte\",\"initialFrame\":1015},{\"lastFrame\":1018,\"eventType\":\"No Corte\",\"initialFrame\":1016},{\"lastFrame\":1019,\"eventType\":\"Corte\",\"initialFrame\":1019},{\"lastFrame\":1020,\"eventType\":\"No Corte\",\"initialFrame\":1020},{\"lastFrame\":1021,\"eventType\":\"Corte\",\"initialFrame\":1021},{\"lastFrame\":1024,\"eventType\":\"No Corte\",\"initialFrame\":1022},{\"lastFrame\":1025,\"eventType\":\"Corte\",\"initialFrame\":1025},{\"lastFrame\":1029,\"eventType\":\"No Corte\",\"initialFrame\":1026},{\"lastFrame\":1030,\"eventType\":\"Corte\",\"initialFrame\":1030},{\"lastFrame\":1034,\"eventType\":\"No Corte\",\"initialFrame\":1031},{\"lastFrame\":1035,\"eventType\":\"Corte\",\"initialFrame\":1035},{\"lastFrame\":1067,\"eventType\":\"No Corte\",\"initialFrame\":1036},{\"lastFrame\":1068,\"eventType\":\"Corte\",\"initialFrame\":1068},{\"lastFrame\":1086,\"eventType\":\"No Corte\",\"initialFrame\":1069},{\"lastFrame\":1087,\"eventType\":\"Corte\",\"initialFrame\":1087},{\"lastFrame\":1092,\"eventType\":\"No Corte\",\"initialFrame\":1088},{\"lastFrame\":1093,\"eventType\":\"Corte\",\"initialFrame\":1093},{\"lastFrame\":1142,\"eventType\":\"No Corte\",\"initialFrame\":1094},{\"lastFrame\":1143,\"eventType\":\"Corte\",\"initialFrame\":1143},{\"lastFrame\":1144,\"eventType\":\"No Corte\",\"initialFrame\":1144},{\"lastFrame\":1145,\"eventType\":\"Corte\",\"initialFrame\":1145},{\"lastFrame\":1147,\"eventType\":\"No Corte\",\"initialFrame\":1146},{\"lastFrame\":1148,\"eventType\":\"Corte\",\"initialFrame\":1148},{\"lastFrame\":1152,\"eventType\":\"No Corte\",\"initialFrame\":1149},{\"lastFrame\":1153,\"eventType\":\"Corte\",\"initialFrame\":1153},{\"lastFrame\":1279,\"eventType\":\"No Corte\",\"initialFrame\":1154},{\"lastFrame\":1280,\"eventType\":\"Corte\",\"initialFrame\":1280},{\"lastFrame\":1281,\"eventType\":\"No Corte\",\"initialFrame\":1281},{\"lastFrame\":1282,\"eventType\":\"Corte\",\"initialFrame\":1282},{\"lastFrame\":1283,\"eventType\":\"No Corte\",\"initialFrame\":1283},{\"lastFrame\":1284,\"eventType\":\"Corte\",\"initialFrame\":1284},{\"lastFrame\":1285,\"eventType\":\"No Corte\",\"initialFrame\":1285},{\"lastFrame\":1286,\"eventType\":\"Corte\",\"initialFrame\":1286},{\"lastFrame\":1294,\"eventType\":\"No Corte\",\"initialFrame\":1287},{\"lastFrame\":1295,\"eventType\":\"Corte\",\"initialFrame\":1295},{\"lastFrame\":1296,\"eventType\":\"No Corte\",\"initialFrame\":1296},{\"lastFrame\":1297,\"eventType\":\"Corte\",\"initialFrame\":1297},{\"lastFrame\":1302,\"eventType\":\"No Corte\",\"initialFrame\":1298},{\"lastFrame\":1303,\"eventType\":\"Corte\",\"initialFrame\":1303},{\"lastFrame\":1307,\"eventType\":\"No Corte\",\"initialFrame\":1304},{\"lastFrame\":1308,\"eventType\":\"Corte\",\"initialFrame\":1308},{\"lastFrame\":1313,\"eventType\":\"No Corte\",\"initialFrame\":1309},{\"lastFrame\":1314,\"eventType\":\"Corte\",\"initialFrame\":1314},{\"lastFrame\":1319,\"eventType\":\"No Corte\",\"initialFrame\":1315},{\"lastFrame\":1320,\"eventType\":\"Corte\",\"initialFrame\":1320},{\"lastFrame\":1322,\"eventType\":\"No Corte\",\"initialFrame\":1321},{\"lastFrame\":1323,\"eventType\":\"Corte\",\"initialFrame\":1323},{\"lastFrame\":1329,\"eventType\":\"No Corte\",\"initialFrame\":1324},{\"lastFrame\":1330,\"eventType\":\"Corte\",\"initialFrame\":1330},{\"lastFrame\":1335,\"eventType\":\"No Corte\",\"initialFrame\":1331},{\"lastFrame\":1336,\"eventType\":\"Corte\",\"initialFrame\":1336},{\"lastFrame\":1341,\"eventType\":\"No Corte\",\"initialFrame\":1337},{\"lastFrame\":1342,\"eventType\":\"Corte\",\"initialFrame\":1342},{\"lastFrame\":1344,\"eventType\":\"No Corte\",\"initialFrame\":1343},{\"lastFrame\":1345,\"eventType\":\"Corte\",\"initialFrame\":1345},{\"lastFrame\":1348,\"eventType\":\"No Corte\",\"initialFrame\":1346},{\"lastFrame\":1349,\"eventType\":\"Corte\",\"initialFrame\":1349},{\"lastFrame\":1352,\"eventType\":\"No Corte\",\"initialFrame\":1350},{\"lastFrame\":1353,\"eventType\":\"Corte\",\"initialFrame\":1353},{\"lastFrame\":1354,\"eventType\":\"No Corte\",\"initialFrame\":1354},{\"lastFrame\":1355,\"eventType\":\"Corte\",\"initialFrame\":1355},{\"lastFrame\":1356,\"eventType\":\"No Corte\",\"initialFrame\":1356},{\"lastFrame\":1357,\"eventType\":\"Corte\",\"initialFrame\":1357},{\"lastFrame\":1359,\"eventType\":\"No Corte\",\"initialFrame\":1358},{\"lastFrame\":1360,\"eventType\":\"Corte\",\"initialFrame\":1360},{\"lastFrame\":1362,\"eventType\":\"No Corte\",\"initialFrame\":1361},{\"lastFrame\":1363,\"eventType\":\"Corte\",\"initialFrame\":1363},{\"lastFrame\":1365,\"eventType\":\"No Corte\",\"initialFrame\":1364},{\"lastFrame\":1366,\"eventType\":\"Corte\",\"initialFrame\":1366},{\"lastFrame\":1368,\"eventType\":\"No Corte\",\"initialFrame\":1367},{\"lastFrame\":1369,\"eventType\":\"Corte\",\"initialFrame\":1369},{\"lastFrame\":1373,\"eventType\":\"No Corte\",\"initialFrame\":1370},{\"lastFrame\":1374,\"eventType\":\"Corte\",\"initialFrame\":1374},{\"lastFrame\":1375,\"eventType\":\"No Corte\",\"initialFrame\":1375},{\"lastFrame\":1376,\"eventType\":\"Corte\",\"initialFrame\":1376},{\"lastFrame\":1377,\"eventType\":\"No Corte\",\"initialFrame\":1377},{\"lastFrame\":1378,\"eventType\":\"Corte\",\"initialFrame\":1378},{\"lastFrame\":1507,\"eventType\":\"No Corte\",\"initialFrame\":1379},{\"lastFrame\":1508,\"eventType\":\"Corte\",\"initialFrame\":1508},{\"lastFrame\":1799,\"eventType\":\"No Corte\",\"initialFrame\":1509},{\"lastFrame\":1800,\"eventType\":\"Corte\",\"initialFrame\":1800},{\"lastFrame\":1802,\"eventType\":\"No Corte\",\"initialFrame\":1801},{\"lastFrame\":1803,\"eventType\":\"Corte\",\"initialFrame\":1803},{\"lastFrame\":1812,\"eventType\":\"No Corte\",\"initialFrame\":1804},{\"lastFrame\":1813,\"eventType\":\"Corte\",\"initialFrame\":1813},{\"lastFrame\":1815,\"eventType\":\"No Corte\",\"initialFrame\":1814},{\"lastFrame\":1816,\"eventType\":\"Corte\",\"initialFrame\":1816},{\"lastFrame\":1817,\"eventType\":\"No Corte\",\"initialFrame\":1817},{\"lastFrame\":1818,\"eventType\":\"Corte\",\"initialFrame\":1818},{\"lastFrame\":1835,\"eventType\":\"No Corte\",\"initialFrame\":1819},{\"lastFrame\":1836,\"eventType\":\"Corte\",\"initialFrame\":1836},{\"lastFrame\":1838,\"eventType\":\"No Corte\",\"initialFrame\":1837},{\"lastFrame\":1839,\"eventType\":\"Corte\",\"initialFrame\":1839},{\"lastFrame\":1840,\"eventType\":\"No Corte\",\"initialFrame\":1840},{\"lastFrame\":1841,\"eventType\":\"Corte\",\"initialFrame\":1841},{\"lastFrame\":1842,\"eventType\":\"No Corte\",\"initialFrame\":1842},{\"lastFrame\":1843,\"eventType\":\"Corte\",\"initialFrame\":1843},{\"lastFrame\":1845,\"eventType\":\"No Corte\",\"initialFrame\":1844},{\"lastFrame\":1846,\"eventType\":\"Corte\",\"initialFrame\":1846},{\"lastFrame\":1847,\"eventType\":\"No Corte\",\"initialFrame\":1847},{\"lastFrame\":1848,\"eventType\":\"Corte\",\"initialFrame\":1848},{\"lastFrame\":1850,\"eventType\":\"No Corte\",\"initialFrame\":1849},{\"lastFrame\":1851,\"eventType\":\"Corte\",\"initialFrame\":1851},{\"lastFrame\":1852,\"eventType\":\"No Corte\",\"initialFrame\":1852},{\"lastFrame\":1853,\"eventType\":\"Corte\",\"initialFrame\":1853},{\"lastFrame\":1854,\"eventType\":\"No Corte\",\"initialFrame\":1854},{\"lastFrame\":1855,\"eventType\":\"Corte\",\"initialFrame\":1855},{\"lastFrame\":1856,\"eventType\":\"No Corte\",\"initialFrame\":1856},{\"lastFrame\":1857,\"eventType\":\"Corte\",\"initialFrame\":1857},{\"lastFrame\":1858,\"eventType\":\"No Corte\",\"initialFrame\":1858},{\"lastFrame\":1859,\"eventType\":\"Corte\",\"initialFrame\":1859},{\"lastFrame\":1910,\"eventType\":\"No Corte\",\"initialFrame\":1860},{\"lastFrame\":1911,\"eventType\":\"Corte\",\"initialFrame\":1911},{\"lastFrame\":1921,\"eventType\":\"No Corte\",\"initialFrame\":1912},{\"lastFrame\":1922,\"eventType\":\"Corte\",\"initialFrame\":1922},{\"lastFrame\":1925,\"eventType\":\"No Corte\",\"initialFrame\":1923},{\"lastFrame\":1926,\"eventType\":\"Corte\",\"initialFrame\":1926},{\"lastFrame\":1927,\"eventType\":\"No Corte\",\"initialFrame\":1927},{\"lastFrame\":1928,\"eventType\":\"Corte\",\"initialFrame\":1928},{\"lastFrame\":1929,\"eventType\":\"No Corte\",\"initialFrame\":1929},{\"lastFrame\":1930,\"eventType\":\"Corte\",\"initialFrame\":1930},{\"lastFrame\":1931,\"eventType\":\"No Corte\",\"initialFrame\":1931},{\"lastFrame\":1932,\"eventType\":\"Corte\",\"initialFrame\":1932},{\"lastFrame\":1933,\"eventType\":\"No Corte\",\"initialFrame\":1933},{\"lastFrame\":1934,\"eventType\":\"Corte\",\"initialFrame\":1934},{\"lastFrame\":1937,\"eventType\":\"No Corte\",\"initialFrame\":1935},{\"lastFrame\":1938,\"eventType\":\"Corte\",\"initialFrame\":1938},{\"lastFrame\":1939,\"eventType\":\"No Corte\",\"initialFrame\":1939},{\"lastFrame\":1940,\"eventType\":\"Corte\",\"initialFrame\":1940},{\"lastFrame\":1942,\"eventType\":\"No Corte\",\"initialFrame\":1941},{\"lastFrame\":1943,\"eventType\":\"Corte\",\"initialFrame\":1943},{\"lastFrame\":1944,\"eventType\":\"No Corte\",\"initialFrame\":1944},{\"lastFrame\":1945,\"eventType\":\"Corte\",\"initialFrame\":1945},{\"lastFrame\":1946,\"eventType\":\"No Corte\",\"initialFrame\":1946},{\"lastFrame\":1947,\"eventType\":\"Corte\",\"initialFrame\":1947},{\"lastFrame\":1948,\"eventType\":\"No Corte\",\"initialFrame\":1948},{\"lastFrame\":1949,\"eventType\":\"Corte\",\"initialFrame\":1949},{\"lastFrame\":1951,\"eventType\":\"No Corte\",\"initialFrame\":1950},{\"lastFrame\":1952,\"eventType\":\"Corte\",\"initialFrame\":1952},{\"lastFrame\":1953,\"eventType\":\"No Corte\",\"initialFrame\":1953},{\"lastFrame\":1954,\"eventType\":\"Corte\",\"initialFrame\":1954},{\"lastFrame\":1956,\"eventType\":\"No Corte\",\"initialFrame\":1955},{\"lastFrame\":1957,\"eventType\":\"Corte\",\"initialFrame\":1957},{\"lastFrame\":1958,\"eventType\":\"No Corte\",\"initialFrame\":1958},{\"lastFrame\":1959,\"eventType\":\"Corte\",\"initialFrame\":1959},{\"lastFrame\":2016,\"eventType\":\"No Corte\",\"initialFrame\":1960},{\"lastFrame\":2017,\"eventType\":\"Corte\",\"initialFrame\":2017},{\"lastFrame\":2018,\"eventType\":\"No Corte\",\"initialFrame\":2018},{\"lastFrame\":2019,\"eventType\":\"Corte\",\"initialFrame\":2019},{\"lastFrame\":2021,\"eventType\":\"No Corte\",\"initialFrame\":2020},{\"lastFrame\":2022,\"eventType\":\"Corte\",\"initialFrame\":2022},{\"lastFrame\":2023,\"eventType\":\"No Corte\",\"initialFrame\":2023},{\"lastFrame\":2024,\"eventType\":\"Corte\",\"initialFrame\":2024},{\"lastFrame\":2025,\"eventType\":\"No Corte\",\"initialFrame\":2025},{\"lastFrame\":2026,\"eventType\":\"Corte\",\"initialFrame\":2026},{\"lastFrame\":2027,\"eventType\":\"No Corte\",\"initialFrame\":2027},{\"lastFrame\":2028,\"eventType\":\"Corte\",\"initialFrame\":2028},{\"lastFrame\":2029,\"eventType\":\"No Corte\",\"initialFrame\":2029},{\"lastFrame\":2030,\"eventType\":\"Corte\",\"initialFrame\":2030},{\"lastFrame\":2032,\"eventType\":\"No Corte\",\"initialFrame\":2031},{\"lastFrame\":2033,\"eventType\":\"Corte\",\"initialFrame\":2033},{\"lastFrame\":2034,\"eventType\":\"No Corte\",\"initialFrame\":2034},{\"lastFrame\":2035,\"eventType\":\"Corte\",\"initialFrame\":2035},{\"lastFrame\":2036,\"eventType\":\"No Corte\",\"initialFrame\":2036},{\"lastFrame\":2037,\"eventType\":\"Corte\",\"initialFrame\":2037},{\"lastFrame\":2038,\"eventType\":\"No Corte\",\"initialFrame\":2038},{\"lastFrame\":2039,\"eventType\":\"Corte\",\"initialFrame\":2039},{\"lastFrame\":2040,\"eventType\":\"No Corte\",\"initialFrame\":2040},{\"lastFrame\":2041,\"eventType\":\"Corte\",\"initialFrame\":2041},{\"lastFrame\":2045,\"eventType\":\"No Corte\",\"initialFrame\":2042},{\"lastFrame\":2046,\"eventType\":\"Corte\",\"initialFrame\":2046},{\"lastFrame\":2047,\"eventType\":\"No Corte\",\"initialFrame\":2047},{\"lastFrame\":2048,\"eventType\":\"Corte\",\"initialFrame\":2048},{\"lastFrame\":2049,\"eventType\":\"No Corte\",\"initialFrame\":2049},{\"lastFrame\":2050,\"eventType\":\"Corte\",\"initialFrame\":2050},{\"lastFrame\":2051,\"eventType\":\"No Corte\",\"initialFrame\":2051},{\"lastFrame\":2052,\"eventType\":\"Corte\",\"initialFrame\":2052},{\"lastFrame\":2053,\"eventType\":\"No Corte\",\"initialFrame\":2053},{\"lastFrame\":2054,\"eventType\":\"Corte\",\"initialFrame\":2054},{\"lastFrame\":2055,\"eventType\":\"No Corte\",\"initialFrame\":2055},{\"lastFrame\":2056,\"eventType\":\"Corte\",\"initialFrame\":2056},{\"lastFrame\":2057,\"eventType\":\"No Corte\",\"initialFrame\":2057},{\"lastFrame\":2058,\"eventType\":\"Corte\",\"initialFrame\":2058},{\"lastFrame\":2059,\"eventType\":\"No Corte\",\"initialFrame\":2059},{\"lastFrame\":2060,\"eventType\":\"Corte\",\"initialFrame\":2060},{\"lastFrame\":2061,\"eventType\":\"No Corte\",\"initialFrame\":2061},{\"lastFrame\":2062,\"eventType\":\"Corte\",\"initialFrame\":2062},{\"lastFrame\":2063,\"eventType\":\"No Corte\",\"initialFrame\":2063},{\"lastFrame\":2064,\"eventType\":\"Corte\",\"initialFrame\":2064},{\"lastFrame\":2065,\"eventType\":\"No Corte\",\"initialFrame\":2065},{\"lastFrame\":2066,\"eventType\":\"Corte\",\"initialFrame\":2066},{\"lastFrame\":2067,\"eventType\":\"No Corte\",\"initialFrame\":2067},{\"lastFrame\":2068,\"eventType\":\"Corte\",\"initialFrame\":2068},{\"lastFrame\":2070,\"eventType\":\"No Corte\",\"initialFrame\":2069},{\"lastFrame\":2071,\"eventType\":\"Corte\",\"initialFrame\":2071},{\"lastFrame\":2072,\"eventType\":\"No Corte\",\"initialFrame\":2072},{\"lastFrame\":2073,\"eventType\":\"Corte\",\"initialFrame\":2073},{\"lastFrame\":2074,\"eventType\":\"No Corte\",\"initialFrame\":2074},{\"lastFrame\":2075,\"eventType\":\"Corte\",\"initialFrame\":2075},{\"lastFrame\":2076,\"eventType\":\"No Corte\",\"initialFrame\":2076},{\"lastFrame\":2077,\"eventType\":\"Corte\",\"initialFrame\":2077},{\"lastFrame\":2078,\"eventType\":\"No Corte\",\"initialFrame\":2078},{\"lastFrame\":2079,\"eventType\":\"Corte\",\"initialFrame\":2079},{\"lastFrame\":2080,\"eventType\":\"No Corte\",\"initialFrame\":2080},{\"lastFrame\":2081,\"eventType\":\"Corte\",\"initialFrame\":2081},{\"lastFrame\":2082,\"eventType\":\"No Corte\",\"initialFrame\":2082},{\"lastFrame\":2083,\"eventType\":\"Corte\",\"initialFrame\":2083},{\"lastFrame\":2084,\"eventType\":\"No Corte\",\"initialFrame\":2084},{\"lastFrame\":2085,\"eventType\":\"Corte\",\"initialFrame\":2085},{\"lastFrame\":2087,\"eventType\":\"No Corte\",\"initialFrame\":2086},{\"lastFrame\":2088,\"eventType\":\"Corte\",\"initialFrame\":2088},{\"lastFrame\":2089,\"eventType\":\"No Corte\",\"initialFrame\":2089},{\"lastFrame\":2090,\"eventType\":\"Corte\",\"initialFrame\":2090},{\"lastFrame\":2091,\"eventType\":\"No Corte\",\"initialFrame\":2091},{\"lastFrame\":2092,\"eventType\":\"Corte\",\"initialFrame\":2092},{\"lastFrame\":2093,\"eventType\":\"No Corte\",\"initialFrame\":2093},{\"lastFrame\":2094,\"eventType\":\"Corte\",\"initialFrame\":2094},{\"lastFrame\":2095,\"eventType\":\"No Corte\",\"initialFrame\":2095},{\"lastFrame\":2096,\"eventType\":\"Corte\",\"initialFrame\":2096},{\"lastFrame\":2097,\"eventType\":\"No Corte\",\"initialFrame\":2097},{\"lastFrame\":2098,\"eventType\":\"Corte\",\"initialFrame\":2098},{\"lastFrame\":2099,\"eventType\":\"No Corte\",\"initialFrame\":2099},{\"lastFrame\":2100,\"eventType\":\"Corte\",\"initialFrame\":2100},{\"lastFrame\":2213,\"eventType\":\"No Corte\",\"initialFrame\":2101},{\"lastFrame\":2214,\"eventType\":\"Corte\",\"initialFrame\":2214},{\"lastFrame\":2357,\"eventType\":\"No Corte\",\"initialFrame\":2215},{\"lastFrame\":2358,\"eventType\":\"Corte\",\"initialFrame\":2358},{\"lastFrame\":2359,\"eventType\":\"No Corte\",\"initialFrame\":2359},{\"lastFrame\":2360,\"eventType\":\"Corte\",\"initialFrame\":2360},{\"lastFrame\":2366,\"eventType\":\"No Corte\",\"initialFrame\":2361},{\"lastFrame\":2367,\"eventType\":\"Corte\",\"initialFrame\":2367},{\"lastFrame\":2371,\"eventType\":\"No Corte\",\"initialFrame\":2368},{\"lastFrame\":2372,\"eventType\":\"Corte\",\"initialFrame\":2372},{\"lastFrame\":2373,\"eventType\":\"No Corte\",\"initialFrame\":2373},{\"lastFrame\":2374,\"eventType\":\"Corte\",\"initialFrame\":2374},{\"lastFrame\":2376,\"eventType\":\"No Corte\",\"initialFrame\":2375},{\"lastFrame\":2377,\"eventType\":\"Corte\",\"initialFrame\":2377},{\"lastFrame\":2379,\"eventType\":\"No Corte\",\"initialFrame\":2378},{\"lastFrame\":2380,\"eventType\":\"Corte\",\"initialFrame\":2380},{\"lastFrame\":2383,\"eventType\":\"No Corte\",\"initialFrame\":2381},{\"lastFrame\":2384,\"eventType\":\"Corte\",\"initialFrame\":2384},{\"lastFrame\":2385,\"eventType\":\"No Corte\",\"initialFrame\":2385},{\"lastFrame\":2386,\"eventType\":\"Corte\",\"initialFrame\":2386},{\"lastFrame\":2387,\"eventType\":\"No Corte\",\"initialFrame\":2387},{\"lastFrame\":2388,\"eventType\":\"Corte\",\"initialFrame\":2388},{\"lastFrame\":2389,\"eventType\":\"No Corte\",\"initialFrame\":2389},{\"lastFrame\":2390,\"eventType\":\"Corte\",\"initialFrame\":2390},{\"lastFrame\":2392,\"eventType\":\"No Corte\",\"initialFrame\":2391},{\"lastFrame\":2393,\"eventType\":\"Corte\",\"initialFrame\":2393},{\"lastFrame\":2395,\"eventType\":\"No Corte\",\"initialFrame\":2394},{\"lastFrame\":2396,\"eventType\":\"Corte\",\"initialFrame\":2396},{\"lastFrame\":2400,\"eventType\":\"No Corte\",\"initialFrame\":2397},{\"lastFrame\":2401,\"eventType\":\"Corte\",\"initialFrame\":2401},{\"lastFrame\":2402,\"eventType\":\"No Corte\",\"initialFrame\":2402},{\"lastFrame\":2403,\"eventType\":\"Corte\",\"initialFrame\":2403},{\"lastFrame\":2404,\"eventType\":\"No Corte\",\"initialFrame\":2404},{\"lastFrame\":2405,\"eventType\":\"Corte\",\"initialFrame\":2405},{\"lastFrame\":2407,\"eventType\":\"No Corte\",\"initialFrame\":2406},{\"lastFrame\":2408,\"eventType\":\"Corte\",\"initialFrame\":2408},{\"lastFrame\":2409,\"eventType\":\"No Corte\",\"initialFrame\":2409},{\"lastFrame\":2410,\"eventType\":\"Corte\",\"initialFrame\":2410},{\"lastFrame\":2412,\"eventType\":\"No Corte\",\"initialFrame\":2411},{\"lastFrame\":2413,\"eventType\":\"Corte\",\"initialFrame\":2413},{\"lastFrame\":2414,\"eventType\":\"No Corte\",\"initialFrame\":2414},{\"lastFrame\":2415,\"eventType\":\"Corte\",\"initialFrame\":2415},{\"lastFrame\":2418,\"eventType\":\"No Corte\",\"initialFrame\":2416},{\"lastFrame\":2419,\"eventType\":\"Corte\",\"initialFrame\":2419},{\"lastFrame\":2424,\"eventType\":\"No Corte\",\"initialFrame\":2420},{\"lastFrame\":2425,\"eventType\":\"Corte\",\"initialFrame\":2425},{\"lastFrame\":2427,\"eventType\":\"No Corte\",\"initialFrame\":2426},{\"lastFrame\":2428,\"eventType\":\"Corte\",\"initialFrame\":2428},{\"lastFrame\":2429,\"eventType\":\"No Corte\",\"initialFrame\":2429},{\"lastFrame\":2430,\"eventType\":\"Corte\",\"initialFrame\":2430},{\"lastFrame\":2648,\"eventType\":\"No Corte\",\"initialFrame\":2431},{\"lastFrame\":2649,\"eventType\":\"Corte\",\"initialFrame\":2649},{\"lastFrame\":3435,\"eventType\":\"No Corte\",\"initialFrame\":2650},{\"lastFrame\":3436,\"eventType\":\"Corte\",\"initialFrame\":3436}]}";
		
		assertEquals( resultadoesperado , archivo);
		
	}

}